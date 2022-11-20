import sys
sys.path.append("..")

from typing import Optional
from fastapi import Depends, HTTPException, APIRouter
import models
from database import engine, SessionLocal
from sqlalchemy.orm import Session
from pydantic import BaseModel, Field
from .auth import get_current_user, get_user_exception


router = APIRouter(
    prefix="/Reports",
    tags=["Reports"],
    responses={404: {"Report": "Not found"}}
)

models.Base.metadata.create_all(bind=engine)


def get_db():
    try:
        db = SessionLocal()
        yield db
    finally:
        db.close()


class Missing_report(BaseModel):
    document_number: str


@router.get("/")
async def read_all(db: Session = Depends(get_db)):
    return db.query(models.Missing_reports).all()


@router.get("/reports")
async def read_all_by_user(user: dict = Depends(get_current_user),
                           db: Session = Depends(get_db)):
    
    if user is None:
        raise get_user_exception()
    return db.query(models.Missing_reports)\
        .filter(models.Missing_reports.owner_report_id == user.get("id"))\
        .all()


@router.get("/{report_id}")
async def read_report(report_id: int,
                    user: dict = Depends(get_current_user),
                    db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()
    report_model = db.query(models.Missing_reports)\
        .filter(models.Missing_reports.id == report_id)\
        .filter(models.Missing_reports.owner_report_id == user.get("id"))\
        .first()
    if report_model is not None:
        return report_model
    raise http_exception()


@router.post("/")
async def create_report(report: Missing_report,
                      user: dict = Depends(get_current_user),
                      db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()
    report_model = models.Missing_reports()
    report_model.document_number = report.document_number
    report_model.owner_report_id = user.get("id")

    db.add(report_model)
    db.commit()

    return successful_response(201)

def successful_response(status_code: int):
    return {
        'status': status_code,
        'transaction': 'Successful'
    }


@router.put("/{report_id}")
async def update_report(report_id: int,
                      report: Missing_report,
                      user: dict = Depends(get_current_user),
                      db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()

    report_model = db.query(models.Missing_reports)\
        .filter(models.Missing_reports.id == report_id)\
        .filter(models.Missing_reports.owner_report_id == user.get("id"))\
        .first()

    if report_model is None:
        raise http_exception()

    report_model.document_number= report.document_number
    db.add(report_model)
    db.commit()

    return successful_response(200)


@router.delete("/{report_id}")
async def delete_report(report_id: int,
                      user: dict = Depends(get_current_user),
                      db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()

    report_model = db.query(models.Missing_reports)\
        .filter(models.Missing_reports.id == report_id)\
        .filter(models.Missing_reports.owner_report_id == user.get("id"))\
        .first()

    if report_model is None:
        raise http_exception()

    db.query(models.Missing_reports)\
        .filter(models.Missing_reports.id == report_id)\
        .delete()

    db.commit()

    return successful_response(200)

def http_exception():
    return HTTPException(status_code=404, detail="Report not found")
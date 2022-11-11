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
    prefix="/Documents",
    tags=["Documents"],
    responses={404: {"description": "Not found"}}
)

models.Base.metadata.create_all(bind=engine)


def get_db():
    try:
        db = SessionLocal()
        yield db
    finally:
        db.close()


class Documents(BaseModel):
    document_type: str
    numero_id: str
    status: bool


@router.get("/")
async def read_all(db: Session = Depends(get_db)):
    return db.query(models.Documents).all()


@router.get("/user")
async def read_all_by_user(user: dict = Depends(get_current_user),
                           db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()
    return db.query(models.Documents)\
        .filter(models.Documents.owner_id == user.get("id"))\
        .all()


@router.get("/{document_id}")
async def read_document(document_id: int,
                    user: dict = Depends(get_current_user),
                    db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()
    document_model = db.query(models.Documents)\
        .filter(models.Documents.id == document_id)\
        .filter(models.Documents.owner_id == user.get("id"))\
        .first()
    if document_model is not None:
        return document_model
    raise http_exception()


@router.post("/")
async def create_document(document: Documents,
                      user: dict = Depends(get_current_user),
                      db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()
    document_model = models.Documents()
    document_model.document_type = document.document_type
    document_model.numero_id = document.numero_id
    document_model.status = document.status
    document_model.owner_id = user.get("id")

    db.add(document_model)
    db.commit()

    return successful_response(201)


@router.put("/{document_id}")
async def update_document(document_id: int,
                      document: Documents,
                      user: dict = Depends(get_current_user),
                      db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()

    document_model = db.query(models.Documents)\
        .filter(models.Documents.id == document_id)\
        .filter(models.Documents.owner_id == user.get("id"))\
        .first()

    if document_model is None:
        raise http_exception()

    document_model.document_type = document.document_type
    document_model.numero_id = document.numero_id
    document_model.status = document.status

    db.add(document_model)
    db.commit()

    return successful_response(200)


@router.delete("/{document_id}")
async def delete_document(document_id: int,
                      user: dict = Depends(get_current_user),
                      db: Session = Depends(get_db)):
    if user is None:
        raise get_user_exception()

    document_model = db.query(models.Documents)\
        .filter(models.Documents.id == document_id)\
        .filter(models.Documents.owner_id == user.get("id"))\
        .first()

    if document_model is None:
        raise http_exception()

    db.query(models.Documents)\
        .filter(models.Documents.id == document_id)\
        .delete()

    db.commit()

    return successful_response(200)


def successful_response(status_code: int):
    return {
        'status': status_code,
        'transaction': 'Successful'
    }


def http_exception():
    return HTTPException(status_code=404, detail="Document not found")

















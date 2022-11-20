from sqlalchemy import Boolean, Column, Integer, String, ForeignKey
from sqlalchemy.orm import relationship
from database import Base


class Users(Base):
    __tablename__ = "users"

    id = Column(Integer, primary_key=True, index=True)
    email = Column(String, unique=True, index=True)
    username = Column(String, unique=True, index=True)
    first_name = Column(String)
    last_name = Column(String)
    hashed_password = Column(String)
    is_active = Column(Boolean, default=True)

    documents = relationship("Documents", back_populates="owner")
    reports = relationship("Missing_reports", back_populates="owner") #Relation with missing_reports


class Documents(Base):
    __tablename__ = "documents"

    id = Column(Integer, primary_key=True, index=True)
    document_type = Column(String)
    numero_id = Column(String)
    status = Column(Boolean)
    owner_id = Column(Integer, ForeignKey("users.id"))

    owner = relationship("Users", back_populates="documents") #Relation with users


class Missing_reports(Base):
    __tablename__ = "missing_reports"

    id = Column(Integer, primary_key=True, index=True)
    document_number = Column(String)
    owner_report_id = Column(Integer, ForeignKey("users.id"))

    owner = relationship("Users", back_populates="reports")



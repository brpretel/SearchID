from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base

# MYSQL Series
SQLALCHEMY_DATABASE_URL = "mysql+pymysql://datadeck_brpretel:Brian0625@162.241.24.215:3306/datadeck_searchid"

engine = create_engine(
    SQLALCHEMY_DATABASE_URL  #SQLALCHEMY_DATABASE_URL, connect_args={"check_same_thread":False} --> connect_args son parametros para sqlite
)

SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind= engine) #Instance of a database session

Base = declarative_base() #Create the database model

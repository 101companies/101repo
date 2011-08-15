#include "companyobject.h"

CompanyObject::CompanyObject(){}

int CompanyObject::getID()
{
    return cID;
}
void CompanyObject::setID(int iD)
{
    cout<< iD << endl;
    cID=iD;
}
char CompanyObject::getTypeInfo()
{
    return typeInfo;
}
void CompanyObject::setTypeInfo(char t)
{
    typeInfo = t;
}

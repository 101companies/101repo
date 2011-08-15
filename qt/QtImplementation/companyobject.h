#ifndef COMPANYOBJECT_H
#define COMPANYOBJECT_H
#include <iostream>
using namespace std;

class CompanyObject
{
public:
    CompanyObject();
    int getID();
    void setID(int iD);
    char getTypeInfo();
    void setTypeInfo(char t);
private:
    int cID;
    char typeInfo;
};

#endif // COMPANYOBJECT_H

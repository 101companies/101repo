#ifndef HR_DEPARTMENT_HPP_INCLUDED
#define HR_DEPARTMENT_HPP_INCLUDED

#include <mpl/list.hpp>

template <typename Name,
          typename Manager,
          typename Employees,
          typename SubDepartments = list<>
         >
struct department
{
    typedef Name name;
    typedef Manager manager;
    typedef Employees employees;
    typedef SubDepartments sub_departments;
    
    ASSERT_LIST(employees);
    ASSERT_LIST(sub_departments);
};

#endif/*HR_DEPARTMENT_HPP_INCLUDED*/

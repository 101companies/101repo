#ifndef HR_EMPLOYEE_HPP_INCLUDED
#define HR_EMPLOYEE_HPP_INCLUDED

#include <mpl/wrapped_value.hpp>

template <typename Name,
          unsigned Salary,
          typename Address = void,
          typename Position = void
         >
struct employee
{
    typedef Name name;
    typedef wrapped_value<unsigned, Salary> salary;
    typedef Address address;
    typedef Position position;
};

#endif/*HR_EMPLOYEE_HPP_INCLUDED*/

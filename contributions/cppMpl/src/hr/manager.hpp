#ifndef HR_MANAGER_HPP_INCLUDED
#define HR_MANAGER_HPP_INCLUDED

#include "employee.hpp"

template <typename Name,
          unsigned Salary,
          typename Address = void,
          typename Position = void
         >
struct manager :
        employee<Name, Salary, Address, Position>
{ };

#endif/*HR_MANAGER_HPP_INCLUDED*/

#ifndef HR_OPERATIONS_HPP_INCLUDED
#define HR_OPERATIONS_HPP_INCLUDED

#include "department.hpp"
#include "employee.hpp"
#include "manager.hpp"

#include <mpl/concat.hpp>
#include <mpl/for_each.hpp>
#include <mpl/reduce.hpp>
#include <mpl/wrapped_value.hpp>

struct select_manager
{
    template <typename TDepartment>
    struct apply
    {
        typedef typename TDepartment::manager result;
    };
};

struct select_employees
{
    template <typename TDepartment>
    struct apply
    {
        typedef typename TDepartment::employees result;
    };
};

struct select_all_employees
{
    template <typename TDepartment>
    struct apply
    {
        typedef typename list_append::apply<typename TDepartment::employees,
                                            typename TDepartment::manager
                                           >::result
                local_employees;
        typedef typename concat_list::apply<typename for_each<select_all_employees,
                                                       typename TDepartment::sub_departments
                                                      >::result
                                    >::result sub_department_employees;
        
        typedef typename concat::apply<local_employees, sub_department_employees>::result result;
    };
};

struct select_salary
{
    template <typename Employee>
    struct apply
    {
        typedef typename Employee::salary result;
    };
};

template <typename SalaryChanger>
struct change_employee_salary
{
    template <typename Employee>
    struct apply
    {
        typedef employee<typename Employee::name,
                         SalaryChanger::template apply<typename Employee::salary>::result::value,
                         typename Employee::address,
                         typename Employee::position
                        > result;
    };
};

template <typename Function>
struct transform_department_employees
{
    template <typename Department>
    struct apply
    {
        typedef typename Function::template apply<typename Department::manager>::result new_manager;
        typedef typename for_each<Function, typename Department::employees>::result new_employees;
        typedef typename for_each<transform_department_employees<Function>,
                                  typename Department::sub_departments
                                 >::result new_subdepartments;
        
        typedef department
                <
                    typename Department::name,
                    new_manager,
                    new_employees,
                    new_subdepartments
                >
            result;
    };
};

template <typename Company>
struct aggregator
{
    typedef typename Company::departments departments;
    typedef typename concat_list::apply
                     <
                        typename for_each<select_all_employees, departments>::result
                     >::result all_employees;
    typedef typename for_each<select_salary, all_employees>::result all_employees_salary;
    typedef typename reduce<add, wrapped_value<unsigned, 0>, all_employees_salary>::result salary_sum;
};

#endif/*HR_OPERATIONS_HPP_INCLUDED*/

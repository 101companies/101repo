#ifndef DATABASE_HPP_INCLUDED
#define DATABASE_HPP_INCLUDED

#include <hr/company.hpp>
#include <hr/department.hpp>
#include <hr/employee.hpp>
#include <hr/manager.hpp>

typedef company
        <
            struct compilers_only,
            list //departments
            <
                department
                <
                    struct head,
                    manager<struct head_honcho, 1000000>,
                    list // employees
                    <
                        employee<struct harold_header, 50000>,
                        employee<struct mark_metaprogrammer, 60000>
                    >,
                    list // subdepartments
                    <
                        department
                        <
                            struct include_guard,
                            manager<struct pointy_hair, 100000>,
                            list<>
                        >
                    >
                >
            >
        >
    all_data;

#endif/*DATABASE_HPP_INCLUDED*/

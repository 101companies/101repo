#include <iostream>

#include "database.hpp"
#include <hr/operations.hpp>

int main()
{
    typedef company<all_data::name,
                    for_each<transform_department_employees<change_employee_salary<divide_by<unsigned, 2>>>,
                             all_data::departments
                            >::result
                   > new_company;
    
    std::cout << "Cut: " << aggregator<new_company>::salary_sum::value << std::endl;
}

#ifndef HR_COMPANY_HPP_INCLUDED
#define HR_COMPANY_HPP_INCLUDED

#include <mpl/list.hpp>

template <typename Name,
          typename Departments
         >
struct company
{
    typedef Name name;
    typedef Departments departments;
    
    ASSERT_LIST(departments);
};

#endif/*HR_COMPANY_HPP_INCLUDED*/

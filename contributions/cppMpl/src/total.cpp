#include <iostream>

#include "database.hpp"
#include <hr/operations.hpp>

int main()
{
    std::cout << "Total: " << aggregator<all_data>::salary_sum::value << std::endl;
}

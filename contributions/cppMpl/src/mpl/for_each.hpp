#ifndef MPL_FOR_EACH_HPP_INCLUDED
#define MPL_FOR_EACH_HPP_INCLUDED

#include "list.hpp"

template <typename Function,
          typename RollingList,
          typename RemainingList
         >
struct for_each_impl
{
    ASSERT_LIST(RollingList);
    ASSERT_LIST(RemainingList);
};

template <typename Function,
          typename... RollingItems
         >
struct for_each_impl<Function,
                     list<RollingItems...>,
                     list<>
                    >
{
    typedef list<RollingItems...> result;
};

template <typename Function,
          typename... RollingItems,
          typename Current,
          typename... RemainingItems
         >
struct for_each_impl<Function, list<RollingItems...>, list<Current, RemainingItems...>> :
        for_each_impl<Function,
                      list<RollingItems..., typename Function::template apply<Current>::result>,
                      list<RemainingItems...>
                     >
{ };

template <typename Function,
          typename List
         >
struct for_each
{
    ASSERT_LIST(List);
    typedef typename for_each_impl<Function, list<>, List>::result result;
};

#endif/*MPL_FOR_EACH_HPP_INCLUDED*/

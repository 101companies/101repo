#ifndef MPL_CONCAT_HPP_INCLUDED
#define MPL_CONCAT_HPP_INCLUDED

#include "list.hpp"

template <typename RollingList,
          typename... Lists
         >
struct concat_impl;

template <typename RollingList>
struct concat_impl<RollingList>
{
    typedef RollingList result;
    ASSERT_LIST(result);
};

template <typename A, typename B>
struct concat_two
{
    ASSERT_LIST(A);
    ASSERT_LIST(B);
};

template <typename... AItems, typename... BItems>
struct concat_two<list<AItems...>, list<BItems...>>
{
    typedef list<AItems..., BItems...> result;
};

template <typename RollingList,
          typename CurrentList,
          typename... RemainingLists
         >
struct concat_impl<RollingList, CurrentList, RemainingLists...> :
        concat_impl<typename concat_two<RollingList, CurrentList>::result,
                    RemainingLists...
                   >
{
    ASSERT_LIST(RollingList);
};

struct concat
{
    template <typename... Lists>
    struct apply
    {
        typedef typename concat_impl<list<>, Lists...>::result result;
    };
};

struct concat_list
{
    template <typename Lists>
    struct apply
    {
        ASSERT_LIST(Lists);
    };
    
    template <typename... Lists>
    struct apply<list<Lists...>>
    {
        typedef typename concat::apply<Lists...>::result result;
    };
};

#endif/*MPL_CONCAT_HPP_INCLUDED*/

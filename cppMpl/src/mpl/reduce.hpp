#ifndef MPL_REDUCE_HPP_INCLUDED
#define MPL_REDUCE_HPP_INCLUDED

#include "list.hpp"

template <typename Func,
          typename Init,
          typename List
         >
struct reduce_impl
{
    ASSERT_LIST(List);
};

template <typename Func,
          typename Init
         >
struct reduce_impl<Func, Init, list<> >
{
    typedef Init result;
};

template <typename Func,
          typename Init,
          typename Current,
          typename... Rest
         >
struct reduce_impl<Func, Init, list<Current, Rest...>> :
        reduce_impl<Func,
                    typename Func::template apply<Init, Current>::result,
                    list<Rest...>
                   >
{ };

template <typename Func,
          typename Init,
          typename... Rest
         >
struct reduce_nolist : reduce_impl<Func, Init, list<Rest...>>
{ };

template <typename Func,
          typename Init,
          typename List
         >
struct reduce
{
    ASSERT_LIST(List);
    typedef typename reduce_impl<Func, Init, List>::result result;
};

#endif/*MPL_REDUCE_HPP_INCLUDED*/

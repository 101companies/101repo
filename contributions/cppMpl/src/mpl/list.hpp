#ifndef MPL_LIST_HPP_INCLUDED
#define MPL_LIST_HPP_INCLUDED

#include <type_traits>

template <typename... T>
struct list
{
    enum { size = sizeof...(T) };
};

template <typename... T>
struct list_first_and_rest;

template <typename First, typename... Rest>
struct list_first_and_rest<First, Rest...>
{
    typedef First first;
    typedef list<Rest...> rest;
};

template <typename... T>
struct list_first
{
    typedef typename list_first_and_rest<T...>::first value;
};

template <typename... T>
struct list_rest
{
    typedef typename list_first_and_rest<T...>::rest value;
};

struct list_append
{
    template <typename List, typename New>
    struct apply;
    
    template <typename... ListItems, typename New>
    struct apply<list<ListItems...>, New>
    {
        typedef list<ListItems..., New> result;
    };
};

template <typename T>
struct is_list : std::false_type
{ };

template <typename... T>
struct is_list<list<T...>> : std::true_type
{ };

#define ASSERT_LIST(type) static_assert(is_list<type>::value, #type " must be a list")

#endif/*MPL_LIST_HPP_INCLUDED*/

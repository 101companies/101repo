#ifndef MPL_WRAPPED_VALUE_HPP_INCLUDED
#define MPL_WRAPPED_VALUE_HPP_INCLUDED

template <typename T, T Value>
struct wrapped_value
{
    typedef T value_type;
    static const T value = Value;
};

struct add
{
    template <typename A, typename B>
    struct apply;
    
    template <typename T, T A, T B>
    struct apply<wrapped_value<T, A>, wrapped_value<T, B> >
    {
        typedef wrapped_value<T, A + B> result;
    };
};

template <typename T, T Divisor>
struct divide_by
{
    template <typename U>
    struct apply;
    
    template <T A>
    struct apply<wrapped_value<T, A> >
    {
        typedef wrapped_value<T, A / Divisor> result;
    };
};

#endif/*MPL_WRAPPED_VALUE_HPP_INCLUDED*/

{- | This comment is placed before the module header and thus
     is seen as the general description of the module. Since 
     the general description may be a bit longer, it is quite 
     common to see a multi-line comment in this position. -}

module Main (
 foo
) where

-- | The "|" character in the comment expresses that this
-- comment should contribute to the generated documentation.
-- Haddock does indeed search for such comments. 
-- We note that 'foo' is indeed exported and thus it 
-- deserves documentation. We could also use a multi-line 
-- comment of course.
foo :: () -> ()
foo = id

-- This function is not exported.
-- Thus, no Haddock comment is needed.
-- That is, the function will not appear in generated documentation.
bar :: () -> Bool
bar = const True

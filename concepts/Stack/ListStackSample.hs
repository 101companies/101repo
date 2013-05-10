{- Illustration of stacks -}

import ListStack

main = do
  let stack1 = push 1 empty
  let stack2 = push 2 stack1
  print $ top stack1 -- 1
  print $ top stack2 -- 2
  print $ top (pop stack2) -- 1
  print $ isEmpty (pop stack1) -- True
  print $ isEmpty (pop stack2) -- False

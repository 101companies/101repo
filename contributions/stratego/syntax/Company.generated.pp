[
   Company             -- KW["company"] _1 KW["{"] _2 KW["}"],
   Company.2:iter-star -- _1,
   Dept                -- KW["dept"] _1 KW["{"] KW["manager"] _2 _3 KW["}"],
   Dept.3:iter-star    -- _1,
   Pu                  -- KW["employee"] _1,
   Du                  -- _1,
   Employee            -- _1 KW["{"] KW["address"] _2 KW["salary"] _3 KW["}"]
]
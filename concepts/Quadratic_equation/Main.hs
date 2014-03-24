-- Solve a quadratic equation
solve a b c
  = if d < 0
      then Nothing
      else Just ((-b + s) / (2 * a), (-b - s) / (2 * a))
  where
    -- Discriminant
    d = b^2 - 4 * a * c
    -- Possibly undefined sqare root of discriminant
    s = sqrt d

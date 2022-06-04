import RpnSyntax
import RpnEval
import StackImpl(simpleImpl)

main = do 
          print $ eval simpleImpl sample

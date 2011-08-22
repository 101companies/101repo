import            Text.Templating.Heist
import qualified  Data.Text as T
import qualified  Text.XmlHtml as X
import           Snap.Types
import           Snap.Extension.Heist

factSplice = do
    input <- getParamNode
    let text = T.unpack $ X.nodeText input
        n = read text :: Int
    return [X.TextNode $ T.pack $ show $ product [1..n]]
    
    

s =  bindSplice (T.pack "fact") factSplice

heistLocals :: MonadHeist n m => m a -> [TemplateState n -> TemplateState n] -> m a
heistLocals = foldl (flip $ heistLocal)
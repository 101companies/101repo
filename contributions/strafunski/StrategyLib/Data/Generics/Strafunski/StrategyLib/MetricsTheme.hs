{-# LANGUAGE MultiParamTypeClasses, OverlappingInstances #-}
------------------------------------------------------------------------------
-- | 
-- Maintainer	: Ralf Laemmel, Joost Visser
-- Stability	: experimental
-- Portability	: portable
--
-- This module is part of 'StrategyLib', a library of functional strategy
-- combinators, including combinators for generic traversal. This module 
-- defines combinators to define metrics extractors.

------------------------------------------------------------------------------

module Data.Generics.Strafunski.StrategyLib.MetricsTheme where

import Control.Monad
import Data.Monoid
import Data.Generics.Strafunski.StrategyLib.StrategyPrelude
import Data.Generics.Strafunski.StrategyLib.OverloadingTheme
import Data.Generics.Strafunski.StrategyLib.FlowTheme

------------------------------------------------------------------------------
-- * An abstract datatype for metrics

-- | The type of metrics
newtype Metrics		=  M (MetricName -> Integer)

-- | The type of metric names
type MetricName		=  String

-- | Create 'Metrics' with given initial value for all metrics.
initMetrics		:: Integer -> Metrics
initMetrics n       	=  M $ \key -> n

-- | Create 'Metrics' with 0 as initial value for all metrics.
initMetrics0		:: Metrics
initMetrics0  		=  initMetrics 0

-- | Create 'Metrics' with
--initTypeMetrics 	:: MetricName -> a -> Metrics
--initTypeMetrics key _   =  incMetrics1 key initMetrics0

-- | Increment metric with the given name with the given value.
incMetrics		:: MetricName -> Integer -> Metrics -> Metrics
incMetrics key n (M m) 	=  M $ \key' -> let val = m key' 
                                        in if key'==key then val+n else val
				    
-- | Increment metric with the given name by 1.
incMetrics1 		:: MetricName -> Metrics -> Metrics				    
incMetrics1 key m 	=  incMetrics key 1 m

-- | Print value of metric with the given name.
putMetricLn		:: MetricName -> Metrics -> IO ()
putMetricLn key (M m) 	=  putStrLn $ key++" = "++show (m key)



-- * Metrics as monoids 
instance Monoid Metrics where
  mempty                = initMetrics0
  mappend (M m1) (M m2) = M $ \s -> (m1 s) + (m2 s)


------------------------------------------------------------------------------
-- * Strategy combinators for metrics

-- | Additionally collect type-based metrics.
typeMetric 
  :: (MonadPlus m, Term a)
  => TU Metrics m 	   -- ^ Metric collecting strategy
  -> (MetricName,a -> ())  -- ^ Name of the metric and type guard
  -> TU Metrics m          -- ^ Strategy that additionally collects type-based metrics
typeMetric s (key,g)
  = op2TU mappend
          (tryTU (ifthenTU (voidTU (typeFilterTU g))
			   (constTU (incMetrics1 key initMetrics0)))) 
          (tryTU s)


-- | Additionally collect predicate-based metrics.
predMetric 
  :: (MonadPlus m, Term b) 
  => TU Metrics m 	    -- ^ Strategy that collects metrics
  -> (MetricName,b -> m ()) -- ^ Name of the metric, and predicate
  -> TU Metrics m	    -- ^ Strategy that additionally collects predicate-based metric
predMetric s (key,g)
  = op2TU mappend 
          (tryTU (ifthenTU (monoTU g)
                           (constTU (incMetrics1 key initMetrics0))))
          (tryTU s)

------------------------------------------------------------------------------
-- * Generic metric algorithms

-- | Generic algorithm for computing nesting depth
depthWith :: MonadPlus m 
          => TU () m      -- ^ Recognize relevant contructs
	  -> TU Int m     -- ^ Count nesting depth of relevant constructs.
depthWith s		
  =  allTU' ((:[]) `dotTU` depthWith s) `passTU` \ds ->
     let max_d = maximum (0:ds)
     in  (s `passTU` \() -> constTU (max_d + 1))
         `choiceTU`
         (constTU max_d)

-------------------------------------------------------------------------------

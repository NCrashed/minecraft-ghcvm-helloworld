{-# LANGUAGE MagicHash #-}
module Export where

import GHC.Base
import GHC.Pack

-- | Our first mod will greet a player on chat command
--
-- `Java class a` is special monad that works in context of Java class `class`
-- and returns type `a`.
sayHello :: JString -> Java Export JString
sayHello n = return . mkJString $ "Hello, " ++ unpackCString n ++ "!"

-- The following line tells GHCVM to create Java class `Export`
-- at package `hello`. We will use it as some sort of interface to Haskell world.
data {-# CLASS "hello.Export" #-} Export = Export (Object# Export)

-- Generate export wrapper that evaulates Haskell thunks
foreign export java sayHello :: JString -> Java Export JString

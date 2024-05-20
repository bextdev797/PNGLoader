# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.bextdev.pngloader.PNGLoader {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/bextdev/pngloader/repack'
-flattenpackagehierarchy
-dontpreverify

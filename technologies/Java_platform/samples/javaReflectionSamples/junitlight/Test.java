package junitlight;

import java.lang.annotation.*;

/**
 * An annotation to tag methods as test methods.
 * The annotations of the annotation carry the following meaning:
 * @Retention implies that the annotation has to be maintained until runtime.
 * @Target means that the annotation is admitted on methods only.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test { }
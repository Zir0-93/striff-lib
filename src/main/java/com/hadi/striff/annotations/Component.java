package com.hadi.striff.annotations;

public @interface Component {

    /**
     * Optional description of the component.
     */
    String value() default "";

    /**
     * Optional category for the component.
     */
    String category() default "";
}

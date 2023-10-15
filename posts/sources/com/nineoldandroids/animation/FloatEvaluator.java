package com.nineoldandroids.animation;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FloatEvaluator implements TypeEvaluator<Number> {
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Float evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(((number2.floatValue() - floatValue) * f) + floatValue);
    }
}

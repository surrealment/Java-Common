package com.surrealment;

/**
 * From Dented Pixel: LeanTween (Unity package)
 * http://dentedpixel.com
 * <p>
 * C# to Java migration by Surreal Entertainment.
 * 7/16/2018
 */
public class seTween {

    public static float Lerp(float start, float end, float val) {
        return Linear(start, end, val);
    }

    public static float Linear(float start, float end, float val) {
        return start + (end - start) * seMath.Clamp01(val);
    }

    public static float Clerp(float start, float end, float val) {
        float min = 0.0f;
        float max = 360.0f;
        float half = Math.abs((max - min) / 2.0f);
        float retval = 0.0f;
        float diff = 0.0f;
        if ((end - start) < -half) {
            diff = ((max - start) + end) * val;
            retval = start + diff;
        } else if ((end - start) > half) {
            diff = -((max - end) + start) * val;
            retval = start + diff;
        } else retval = start + (end - start) * val;
        return retval;
    }

    public static float Spring(float start, float end, float val) {
        val = (float) seMath.Clamp01(val);
        val = (float) (Math.sin(val * Math.PI * (0.2f + 2.5f * val * val * val)) * Math.pow(1f - val, 2.2f) + val) * (1f + (1.2f * (1f - val)));
        return start + (end - start) * val;
    }

    public static float EaseInQuad(float start, float end, float val) {
        end -= start;
        return end * val * val + start;
    }

    public static float EaseOutQuad(float start, float end, float val) {
        end -= start;
        return -end * val * (val - 2) + start;
    }

    public static float EaseInOutQuad(float start, float end, float val) {
        val /= .5f;
        end -= start;
        if (val < 1) return end / 2 * val * val + start;
        val--;
        return -end / 2 * (val * (val - 2) - 1) + start;
    }

    public static float EaseInCubic(float start, float end, float val) {
        end -= start;
        return end * val * val * val + start;
    }

    public static float EaseOutCubic(float start, float end, float val) {
        val--;
        end -= start;
        return end * (val * val * val + 1) + start;
    }

    public static float EaseInOutCubic(float start, float end, float val) {
        val /= .5f;
        end -= start;
        if (val < 1) return end / 2 * val * val * val + start;
        val -= 2;
        return end / 2 * (val * val * val + 2) + start;
    }

    public static float easeInQuart(float start, float end, float val) {
        end -= start;
        return end * val * val * val * val + start;
    }

    public static float EaseOutQuart(float start, float end, float val) {
        val--;
        end -= start;
        return -end * (val * val * val * val - 1) + start;
    }

    public static float EaseInOutQuart(float start, float end, float val) {
        val /= .5f;
        end -= start;
        if (val < 1) return end / 2 * val * val * val * val + start;
        val -= 2;
        return -end / 2 * (val * val * val * val - 2) + start;
    }

    public static float EaseInQuint(float start, float end, float val) {
        end -= start;
        return end * val * val * val * val * val + start;
    }

    public static float EaseOutQuint(float start, float end, float val) {
        val--;
        end -= start;
        return end * (val * val * val * val * val + 1) + start;
    }

    public static float EaseInOutQuint(float start, float end, float val) {
        val /= .5f;
        end -= start;
        if (val < 1) return end / 2 * val * val * val * val * val + start;
        val -= 2;
        return end / 2 * (val * val * val * val * val + 2) + start;
    }

    public static float EaseInSine(float start, float end, float val) {
        end -= start;
        return (float) (-end * Math.cos(val / 1 * (Math.PI / 2)) + end + start);
    }

    public static float EaseOutSine(float start, float end, float val) {
        end -= start;
        return (float) (end * Math.sin(val / 1 * (Math.PI / 2)) + start);
    }

    public static float EaseInOutSine(float start, float end, float val) {
        end -= start;
        return (float) (-end / 2 * (Math.cos(Math.PI * val / 1) - 1) + start);
    }

    public static float EaseInExpo(float start, float end, float val) {
        end -= start;
        return (float) (end * Math.pow(2, 10 * (val / 1 - 1)) + start);
    }

    public static float EaseOutExpo(float start, float end, float val) {
        end -= start;
        return (float) (end * (-Math.pow(2, -10 * val / 1) + 1) + start);
    }

    public static float EaseInOutExpo(float start, float end, float val) {
        val /= .5f;
        end -= start;
        if (val < 1) return (float) (end / 2 * Math.pow(2, 10 * (val - 1)) + start);
        val--;
        return (float) (end / 2 * (-Math.pow(2, -10 * val) + 2) + start);
    }

    public static float EaseInCirc(float start, float end, float val) {
        end -= start;
        return (float) (-end * (Math.sqrt(1 - val * val) - 1) + start);
    }

    public static float EaseOutCirc(float start, float end, float val) {
        val--;
        end -= start;
        return (float) (end * Math.sqrt(1 - val * val) + start);
    }

    public static float EaseInOutCirc(float start, float end, float val) {
        val /= .5f;
        end -= start;
        if (val < 1) return (float) (-end / 2 * (Math.sqrt(1 - val * val) - 1) + start);
        val -= 2;
        return (float) (end / 2 * (Math.sqrt(1 - val * val) + 1) + start);
    }

    public static float EaseInBounce(float start, float end, float val) {
        end -= start;
        float d = 1f;
        return end - EaseOutBounce(0, end, d - val) + start;
    }

    public static float EaseOutBounce(float start, float end, float val) {
        val /= 1f;
        end -= start;
        if (val < (1 / 2.75f)) {
            return end * (7.5625f * val * val) + start;
        } else if (val < (2 / 2.75f)) {
            val -= (1.5f / 2.75f);
            return end * (7.5625f * (val) * val + .75f) + start;
        } else if (val < (2.5 / 2.75)) {
            val -= (2.25f / 2.75f);
            return end * (7.5625f * (val) * val + .9375f) + start;
        } else {
            val -= (2.625f / 2.75f);
            return end * (7.5625f * (val) * val + .984375f) + start;
        }
    }

    public static float EaseInOutBounce(float start, float end, float val) {
        end -= start;
        float d = 1f;
        if (val < d / 2) return EaseInBounce(0, end, val * 2) * 0.5f + start;
        else return EaseOutBounce(0, end, val * 2 - d) * 0.5f + end * 0.5f + start;
    }

    public static float EaseInBack(float start, float end, float val) {
        float overshoot = 1.0f;
        end -= start;
        val /= 1;
        float s = 1.70158f * overshoot;
        return end * (val) * val * ((s + 1) * val - s) + start;
    }

    public static float EaseOutBack(float start, float end, float val) {
        float overshoot = 1.0f;
        float s = 1.70158f * overshoot;
        end -= start;
        val = (val / 1) - 1;
        return end * ((val) * val * ((s + 1) * val + s) + 1) + start;
    }

    public static float EaseInOutBack(float start, float end, float val) {
        float overshoot = 1.0f;
        float s = 1.70158f * overshoot;
        end -= start;
        val /= .5f;
        if ((val) < 1) {
            s *= (1.525f) * overshoot;
            return end / 2 * (val * val * (((s) + 1) * val - s)) + start;
        }
        val -= 2;
        s *= (1.525f) * overshoot;
        return end / 2 * ((val) * val * (((s) + 1) * val + s) + 2) + start;
    }

    public static float EaseInElastic(float start, float end, float val) {
        float overshoot = 1.0f;
        float period = 0.3f;
        end -= start;

        float p = period;
        float s = 0f;
        float a = 0f;

        if (val == 0f) return start;

        if (val == 1f) return start + end;

        if (a == 0f || a < Math.abs(end)) {
            a = end;
            s = p / 4f;
        } else {
            s = (float) (p / (2f * Math.PI) * Math.asin(end / a));
        }

        if (overshoot > 1f && val > 0.6f)
            overshoot = 1f + ((1f - val) / 0.4f * (overshoot - 1f));
        // Debug.Log("ease in elastic val:"+val+" a:"+a+" overshoot:"+overshoot);

        val = val - 1f;
        return (float) (start - (a * Math.pow(2f, 10f * val) * Math.sin((val - s) * (2f * Math.PI) / p)) * overshoot);
    }

    public static float EaseOutElastic(float start, float end, float val) {
        float overshoot = 1.0f;
        float period = 0.3f;
        end -= start;

        float p = period;
        float s = 0f;
        float a = 0f;

        if (val == 0f) return start;

        // Debug.Log("ease out elastic val:"+val+" a:"+a);
        if (val == 1f) return start + end;

        if (a == 0f || a < Math.abs(end)) {
            a = end;
            s = p / 4f;
        } else {
            s = (float) (p / (2f * Math.PI) * Math.asin(end / a));
        }
        if (overshoot > 1f && val < 0.4f)
            overshoot = 1f + (val / 0.4f * (overshoot - 1f));
        // Debug.Log("ease out elastic val:"+val+" a:"+a+" overshoot:"+overshoot);

        return (float) (start + end + a * Math.pow(2f, -10f * val) * Math.sin((val - s) * (2f * Math.PI) / p) * overshoot);
    }

    public static float EaseInOutElastic(float start, float end, float val) {
        end -= start;

        float overshoot = 1.0f;
        float period = 0.3f;
        float p = period;
        float s = 0f;
        float a = 0f;

        if (val == 0f) return start;

        val = val / (1f / 2f);
        if (val == 2f) return start + end;

        if (a == 0f || a < Math.abs(end)) {
            a = end;
            s = p / 4f;
        } else {
            s = (float) (p / (2f * Math.PI) * Math.asin(end / a));
        }

        if (overshoot > 1f) {
            if (val < 0.2f) {
                overshoot = 1f + (val / 0.2f * (overshoot - 1f));
            } else if (val > 0.8f) {
                overshoot = 1f + ((1f - val) / 0.2f * (overshoot - 1f));
            }
        }

        if (val < 1f) {
            val = val - 1f;
            return (float) (start - 0.5f * (a * Math.pow(2f, 10f * val) * Math.sin((val - s) * (2f * Math.PI) / p)) * overshoot);
        }
        val = val - 1f;
        return (float) (end + start + a * Math.pow(2f, -10f * val) * Math.sin((val - s) * (2f * Math.PI) / p) * 0.5f * overshoot);
    }

}

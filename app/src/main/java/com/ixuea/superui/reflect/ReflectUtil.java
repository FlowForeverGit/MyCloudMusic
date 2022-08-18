package com.ixuea.superui.reflect;

import android.view.LayoutInflater;

import com.ixuea.courses.mymusic.activity.BaseViewModelActivity;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import androidx.viewbinding.ViewBinding;

public class ReflectUtil {
    public static <T extends ViewBinding> T newViewBinding(LayoutInflater layoutInflater, Class<?> aClass) {
        try {
            //获取泛型参数对象
            ParameterizedType type;
            try {
                type = (ParameterizedType) aClass.getGenericSuperclass();
            }
            catch (ClassCastException e) {
                type = (ParameterizedType) aClass.getSuperclass().getGenericSuperclass();
            }

            //type.actualTypeArguments[0]: ViewBinding
            Class<T> classT = (Class<T>) type.getActualTypeArguments()[0];

            //获取inflate方法
            Method inflateMethod = classT.getMethod("inflate", LayoutInflater.class);

            return (T) inflateMethod.invoke(null, layoutInflater);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

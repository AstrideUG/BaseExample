package com.astrideug.example;

import com.astrideug.base.ProjectBase;
import com.astrideug.base.loader.ResolvedJar;
import com.astrideug.base.reflections.AdvancedReflections;
import com.astrideug.base.reflections.transform.ModuleTransformer;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class TransformerImpl implements ModuleTransformer {

    @Override
    @SneakyThrows
    public void transform(ResolvedJar resolvedJar, ProjectBase projectBase) {

        //Iterate through all field in ProjectBase annotated with @Change
        for (Field field : AdvancedReflections.getFieldsAnnotatedWith(projectBase.getClass(), Change.class)) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            //Set fields value to 10
            field.set(projectBase, 10);
        }
    }

}

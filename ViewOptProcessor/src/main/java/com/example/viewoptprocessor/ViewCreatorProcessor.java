package com.example.viewoptprocessor;

import com.zhy.demo.viewopt.ViewOptHost;
import com.google.auto.service.AutoService;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
public class ViewCreatorProcessor extends AbstractProcessor {

    private Messager mMessager;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mMessager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        Set<? extends Element> classElements = roundEnvironment.getElementsAnnotatedWith(ViewOptHost.class);

        for (Element element : classElements) {
            TypeElement classElement = (TypeElement) element;
            ViewCreatorClassGenerator viewCreatorClassGenerator = new ViewCreatorClassGenerator(processingEnv, classElement, mMessager);
            viewCreatorClassGenerator.getJavaClassFile();
            break;
        }
        return true;

    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(ViewOptHost.class.getCanonicalName());
        return types;
    }

}

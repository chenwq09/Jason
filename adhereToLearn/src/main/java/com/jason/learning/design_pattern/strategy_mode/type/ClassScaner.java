package com.jason.learning.design_pattern.strategy_mode.type;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author mf
 * @ClassName ClassScaner
 * @Description
 * @date 2019-04-26 14:00
 * @Version 1.0
 */
public class ClassScaner implements ResourceLoaderAware {

    private final List<TypeFilter> includeFilters = new LinkedList<>();

    private final List<TypeFilter> excludeFilters = new LinkedList<>();

    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(this.resourcePatternResolver);

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

        this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);

        this.metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);

    }

    @SafeVarargs
    public static Set<Class<?>> scan(String[] basePackages, Class<? extends Annotation>... annotations){
        ClassScaner cs = new ClassScaner();
        if(ArrayUtils.isNotEmpty(annotations)){
            for(Class anno : annotations){
                cs.addIncludeFilter(new AnnotationTypeFilter(anno));
            }
        }
        Set<Class<?>> classes = new HashSet<>();
        for(String s:basePackages){
            classes.addAll(cs.doScan(s));
        }
        return classes;
    }

    @SafeVarargs
    public static Set<Class<?>> scan(String basePackages,Class<? extends Annotation>... annotation){
        return ClassScaner.scan(StringUtils.tokenizeToStringArray(basePackages, ",; \t\n"), annotation);
    }


    public final ResourceLoader getResourceLoader(){
        return this.resourcePatternResolver;
    }


    private void addIncludeFilter(TypeFilter typeFilter) {
        this.includeFilters.add(typeFilter);
    }

    private void addExcludeFilter(TypeFilter typeFilter){
        this.excludeFilters.add(typeFilter);
    }


    public void resetFilters(boolean useDefaultFilters) {
        this.includeFilters.clear();
        this.excludeFilters.clear();
    }

    private Set<Class<?>> doScan(String basePackage) {
        Set<Class<?>> classes = new HashSet<>();
        try {
           String packageSearchPath =  ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage))+"/**/*.class";

            Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);

            for(int i = 0;i<resources.length; i++){
                Resource resource = resources[i];
                if(resource.isReadable()){
                    MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);
                    if((includeFilters.size()==0 && excludeFilters.size() == 0) || matchs(metadataReader)){
                        try {
                            classes.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("I/O failure during classpath scanning",e);
        }
        return classes;

    }


    protected boolean matchs(MetadataReader metadataReader) throws IOException {
        for(TypeFilter tf :this.excludeFilters){
            if(tf.match(metadataReader,this.metadataReaderFactory)){
                return false;
            }
        }

        for(TypeFilter tf:this.includeFilters){
            if(tf.match(metadataReader,this.metadataReaderFactory)){
                return true;
            }
        }

        return false;
    }
}

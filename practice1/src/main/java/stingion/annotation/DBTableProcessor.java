package stingion.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedAnnotationTypes(value = {"stingion.annotation.DBTable"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class DBTableProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Boolean result = Boolean.TRUE;
        Messager consoleLogger = processingEnv.getMessager();
        try {
            for (Element element : roundEnv.getElementsAnnotatedWith(DBTable.class)) {
                Filer filer = processingEnv.getFiler();
                //JavaFileObject o = filer.createSourceFile("org.example.generated."+
                //element.getSimpleName()+".sql");
                FileObject o = filer.createResource(StandardLocation.SOURCE_OUTPUT,
                        "stingion.annotation.generated", element.getSimpleName() + ".sql");
                Writer w = o.openWriter();

                w.append("CREATE TABLE " + element.getAnnotation(DBTable.class).name());
                w.flush();
                w.close();
                consoleLogger.printMessage(Kind.NOTE, "File finished");
            }
        } catch (IOException ex) {
            consoleLogger.printMessage(Kind.ERROR, ex.getMessage());
        }
        return result;
    }
}

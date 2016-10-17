package hu.elte.txtuml.export.cpp.templates;

import java.util.List;

public class GenerationTemplates {

	public static final String StandardIOinclude = GenerationNames.StandardIOinclude;
	public static final String StandardFunctionsHeader = GenerationNames.StandardLibaryFunctionsHeaderName;
	public static final String DeploymentHeader = GenerationNames.DeploymentHeaderName;
	public static final String TimerInterfaceHeader = GenerationNames.TimerInterFaceName.toLowerCase();
	public static final String TimerHeader = GenerationNames.TimerClassName.toLowerCase();

	public static String headerName(String className) {
		return className + "." + GenerationNames.HeaderExtension;
	}

	public static String sourceName(String className) {
		return className + "." + GenerationNames.SourceExtension;
	}

	public static String dataType(String datatTypeName, String attributes) {
		return GenerationNames.DataType + " " + datatTypeName + "\n" + "{\n" + attributes + "}";
	}

	public static String paramName(String paramName) {
		return GenerationNames.formatIncomingParamName(paramName);
	}

	public static String forwardDeclaration(String className) {
		String source = "";
		String cppType = PrivateFunctionalTemplates.cppType(className);
		if (PrivateFunctionalTemplates.stdType(cppType)) {
			source = PrivateFunctionalTemplates.include(cppType);
		} else {
			source = GenerationNames.ClassType + " " + className + ";\n";
		}
		return source;
	}

	public static String cppInclude(String className) {
		String cppType = PrivateFunctionalTemplates.cppType(className);
		if (PrivateFunctionalTemplates.stdType(cppType)) {
			return PrivateFunctionalTemplates.include(cppType);
		}
		return PrivateFunctionalTemplates.include(className);
	}

	public static String putNamespace(String source, String namespace) {
		return "namespace " + namespace + "\n{\n" + source + "\n}\n";
	}

	public static String formatSubSmFunctions(String source) {
		return source.replaceAll(GenerationNames.Self, GenerationNames.ParentSmMemberName);
	}

	public static String createObject(String typeName, String objName) {
		return createObject(typeName, objName, null, null);
	}

	public static String createObject(String typeName, String objName, List<String> params) {
		return createObject(typeName, objName, null, params);
	}

	public static String createObject(String typeName, String objName, List<String> templateParams,
			List<String> params) {
		String templateParameters = "";
		if (templateParams != null) {
			templateParameters = "<";
			for (int i = 0; i < templateParams.size() - 1; i++) {
				templateParameters = templateParameters + templateParams.get(i) + ",";
			}
			templateParameters = templateParameters + templateParams.get(templateParams.size() - 1) + ">";
		}

		return GenerationNames.pointerType(typeName) + " " + objName + templateParameters + " = "
				+ allocateObject(typeName, templateParams, params) + ";\n";

	}

	public static String allocateObject(String typeName, List<String> templateParams, List<String> params) {

		String parameters = "(";
		if (params != null && params.size() > 0) {

			for (int i = 0; i < params.size() - 1; i++) {
				parameters = parameters + params.get(i) + ",";
			}
			parameters = parameters + params.get(params.size() - 1);
		}
		parameters = parameters + ")";

		String templateParameters = "";
		if (templateParams != null) {
			templateParameters = "<";
			for (int i = 0; i < templateParams.size() - 1; i++) {
				templateParameters = templateParameters + templateParams.get(i) + ",";
			}
			templateParameters = templateParameters + templateParams.get(templateParams.size() - 1) + ">";
		}
		return GenerationNames.MemoryAllocator + " " + typeName + templateParameters + parameters;

	}

	public static String allocateObject(String typeName, List<String> params) {
		return allocateObject(typeName, null, params);
	}

	public static String allocateObject(String typeName) {
		return allocateObject(typeName, null, null);
	}

	public static String staticCreate(String typeName, String objName, String creatorMethod) {
		return GenerationNames.pointerType(typeName) + " " + objName + " = " + staticMethodInvoke(typeName,creatorMethod) + ";\n";
	}
	
	public static String staticMethodInvoke(String className, String method) {
		return className + "::" + method + "()";
	}

	public static String debugOnlyCodeBlock(String code_) {
		return "#ifndef " + GenerationNames.NoDebugSymbol + "\n" + code_ + "#endif\n";
	}

	public static String usingTemplateType(String usedName, String typeName, List<String> templateParams) {
		String templateParameters = "<";
		templateParameters = "<";
		for (int i = 0; i < templateParams.size() - 1; i++) {
			templateParameters = templateParameters + templateParams.get(i) + ",";
		}
		templateParameters = templateParameters + templateParams.get(templateParams.size() - 1) + ">";

		return "using " + usedName + " = " + typeName + templateParameters + ";\n";

	}

}

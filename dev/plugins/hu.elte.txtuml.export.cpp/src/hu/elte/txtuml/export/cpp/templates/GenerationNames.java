package hu.elte.txtuml.export.cpp.templates;

import org.eclipse.core.runtime.Path;

import hu.elte.txtuml.export.cpp.templates.statemachine.EventTemplates;

public class GenerationNames {

	public static class Namespaces {

		public static final String RootNamespace = "ES"; // ELTE-Soft

		public static final String ModelNamespace = "Model";
		public static final String StringUtilsNamespace = "StringUtils";
		public static final String CollectionUtilsNamespace = "CollectionUtils";
		public static final String ContainerNamespace = "ESContainer";
		public static final String ExecutionNamesapce = "Execution";
	}

	public static class FileNames {
		public static final String ESRootFolderName = "ESRoot";
		public static final String ESRootPath = RuntimeTemplates.RTPath + ESRootFolderName + Path.SEPARATOR;
		public static final String FileNameTypes = "Types";
		public static final String TypesFilePath = ESRootPath + FileNameTypes;
		public static final String FileNameAction = "Action";
		public static final String ActionPath = RuntimeTemplates.RTPath + FileNameAction;
		public static final String FileNamesStringUtilsHeaderName = "StringUtils";
		public static final String StringUtilsPath = ESRootPath + FileNamesStringUtilsHeaderName;
		public static final String FileNamesCollectionUtilsHeaderName = "CollectionUtils";
		public static final String CollectionUtilsPath = ESRootPath + FileNamesCollectionUtilsHeaderName;

		public static final String HeaderExtension = "hpp";
		public static final String SourceExtension = "cpp";
	}

	public static class ActionNames {

		public static final String ActionFunctionsNamespace = "Action";
		public static final String SendSignal = ActionFunctionsNamespace + "::" + "send";
		public static final String ActionStart = ActionFunctionsNamespace + "::" + "start";
		public static final String ActionDelete = ActionFunctionsNamespace + "::" + "deleteObject";
		public static final String LinkActionName = ActionFunctionsNamespace + "::" + "link";
		public static final String UnLinkActionName = ActionFunctionsNamespace + "::" + "unlink";
		public static final String Log = ActionFunctionsNamespace + "::" + "log";

	}

	public static class BasicTypeNames {

		public static final String StringTypeName = Namespaces.RootNamespace + "::" + "String";
		public static final String Int32TypeName = "Int32";
		public static final String Int64TypeName = "Int64";

	}

	public static class PointerAndMemoryNames {

		public static final String MemoryAllocator = "new";
		public static final String SimpleAccess = ".";
		public static final String PointerAccess = "->";
		public static final String NullPtr = "nullptr";
		public static final String Self = "this";
		public static final String SmartPtr = "ES::SharedPtr";
		public static final String EventPtr = Namespaces.RootNamespace + "::" + "EventRef";

	}

	public static class CollectionNames {

		public static final String Collection = "std::list";
		public static final String SelectAnyFunctionName = "getOne";
		public static final String SelectAllFunctionName = "getAll";

	}

	public static class TimerNames {

		public static final String TimerInterFaceName = "ITimer";
		public static final String StartTimerFunctionName = "start";
		public static final String TimerClassName = "Timer";
		public static final String TimerPtrName = Namespaces.RootNamespace + "::" + "TimerPtr";

	}

	public static class ModifierNames {

		public static final String NoReturn = "void";
		// Modifies
		public static final String StaticModifier = "static";

	}

	public static class GeneralFunctionNames {
		public static final String GeneralLinkFunction = "link";
		public static final String GeneralUnlinkFunction = "unlink";
		public static final String InitFunctionName = "init";
	}

	public static class Containers {
		public static final String FixContainer = Namespaces.ContainerNamespace + "::" + "FixedArray";
	}

	public static class StateMachineMethodNames {
		public static final String InitFunctionName = "init";
		public static final String ProcessEventFName = "process_event";
		public static final String InitializeFunctionName = "initialize";
		public static final String FinalizeFunctionName = "finalize";
	}
	
	public static class EntryExitNames {

		public static final String EntryName = "entry";
		public static final String ExitName = "exit";
		public static final String EntryDecl = GenerationNames.ModifierNames.NoReturn + " " + EntryName + "("
		+ EventTemplates.EventPointerType + " " + EventTemplates.EventFParamName + ");\n";
		public static final String ExitDecl = GenerationNames.ModifierNames.NoReturn + " " + ExitName + "("
		+ EventTemplates.EventPointerType + " " + EventTemplates.EventFParamName + ");\n";
		public static final String EntryInvoke = EntryName + "(" + EventTemplates.EventFParamName + ");";
		public static final String ExitInvoke = ExitName + "(" + EventTemplates.EventFParamName + ");";
		
	}

	public static class ClassUtilsNames {
		public static final String BaseClassName = Namespaces.RootNamespace + "::" + "ModelObject";
		public static final String StateMachineOwnerBaseName = "StateMachineOwner";
		public static final String NotStateMachineOwnerBaseName = "NotStateMachineOwner";
		public static final String SubStateMachineBase = "SubStateMachine";
	}

	public static class UMLStdLibNames {
		public static final String ModelClassName = "hu.elte.txtuml.api.model.ModelClass";
		public static final String UMLInteger = "Integer";
		public static final String UMLString = "String";
		public static final String UMLReal = "Real";
		public static final String UMLBoolean = "Boolean";
	}

	public static class HierarchicalStateMachineNames {
		public static final String ParentSmName = "pSm";
		public static final String CompositeStateMapName = "_compSates";
		public static final String CurrentMachineName = "_cM";
		public static final String ParentSmMemberName = "_" + ParentSmName;
		public static final String CompositeStateMapSmType = sharedPtrType(
				GenerationNames.ClassUtilsNames.SubStateMachineBase);
		public static final String CompositeStateMap = "std::unordered_map<int," + CompositeStateMapSmType + " > "
				+ CompositeStateMapName + ";\n";
		public static final String CurrentMachine = pointerType(GenerationNames.ClassUtilsNames.SubStateMachineBase)
				+ " " + CurrentMachineName + ";\n";
		public static final String ActionCallerFName = "action_caller";
		public static final String ActionCallerDecl = "bool " + ActionCallerFName + "("
				+ EventTemplates.EventPointerType + " " + EventTemplates.EventFParamName + ");\n";

	}

	public static final String ClassType = "struct";
	public static final String DataType = "struct";
	public static final String EnumName = "enum";

	// NDEBUG is the only thing guaranteed, DEBUG and _DEBUG is non-standard
	public static final String NoDebugSymbol = "NDEBUG";
	public static final String StandardIOInclude = "#include <iostream>\n";

	public static final String StaticCast = "static_cast";
	public static final String IncomingParamTypeId = "_";
	public static final String RealEventName = "realEvent";
	public static final String EventClassTypeId = "_EC";
	public static final String EventEnumTypeId = "_EE";
	public static final String StateEnumTypeId = "_ST";
	public static final String StateParamName = "s_";
	public static final String TransitionTableName = "_mM";
	public static final String SetStateFuncName = "setState";
	public static final String CurrentStateName = "_cS";
	public static final String FunctionPtrTypeName = "ActionFuncType";
	public static final String GuardFuncTypeName = "GuardFuncType";
	public static final String GuardActionName = "GuardAction";
	public static final String EventStateTypeName = "EventState";
	public static final String UnParametrizadProcessEvent = "bool " + StateMachineMethodNames.ProcessEventFName + "("
			+ EventTemplates.EventPointerType + ")";
	public static final String ProcessEventDecl = UnParametrizadProcessEvent + ";\n";
	public static final String SetStateDecl = ModifierNames.NoReturn + " " + SetStateFuncName + "(int "
			+ GenerationNames.StateParamName + ");\n";
	public static final String SetInitialStateName = "setInitialState";
	public static final String SetInitialStateDecl = ModifierNames.NoReturn + " " + SetInitialStateName + "();";
	public static final String StatemachineBaseHeaderName = "statemachinebase";
	public static final String DefaultGuardName = "defaultGuard";
	public static final String AssocMultiplicityDataStruct = "AssociationEnd";
	public static final String AssociationClassName = "Association";
	public static final String AssocationHeaderName = "association";
	public static final String DeploymentHeaderName = "deployment";

	public static final String InitStateMachine = "initStateMachine";

	public static final String PoolIdSetter = "setPoolId";

	public static final String AssigmentOperator = "=";
	public static final String AddAssocToAssocationFunctionName = "addAssoc";
	public static final String RemoveAssocToAssocationFunctionName = "removeAssoc";
	public static final String AssocParameterName = "object";
	public static final String LinkAddition = "link";
	public static final String TemplateDecl = "template";
	public static final String TemplateType = "typename";
	public static final String TemplateParameterName = "T";
	public static final String EndPointName = "EndPointName";

	public static final String AssociationsHeaderName = "associations";
	public static final String EdgeType = "EdgeType";

	public static String initFunctionName(String className) {
		return GeneralFunctionNames.InitFunctionName + className;
	}

	public static String friendClassDecl(String className) {
		return "friend " + GenerationNames.ClassType + " " + className + ";\n";
	}

	public static String actionCallerDef(String className) {
		return "bool " + className + "::" + HierarchicalStateMachineNames.ActionCallerFName + "("
				+ EventTemplates.EventPointerType + " " + EventTemplates.EventFParamName + ")\n"
				+ simpleProcessEventDefBody();
	}

	public static String simpleProcessEventDef(String className) {
		return "bool " + className + "::" + StateMachineMethodNames.ProcessEventFName + "("
				+ EventTemplates.EventPointerType + " " + EventTemplates.EventFParamName + ")\n"
				+ simpleProcessEventDefBody();
	}

	public static String hierachicalProcessEventDef(String className) {
		return "bool " + className + "::" + StateMachineMethodNames.ProcessEventFName + "("
				+ EventTemplates.EventPointerType + " " + EventTemplates.EventFParamName + ")\n" + "{\n"
				+ "bool handled=false;\n" + "if(" + HierarchicalStateMachineNames.CurrentMachineName + ")\n" + "{\n"
				+ "if(" + HierarchicalStateMachineNames.CurrentMachineName + "->"
				+ StateMachineMethodNames.ProcessEventFName + "(" + EventTemplates.EventFParamName + "))\n" + "{\n"
				+ "handled=true;\n" + "}\n" + "}\n" + "if(!handled)\n" + "{\n" + "handled=handled || "
				+ HierarchicalStateMachineNames.ActionCallerFName + "(" + EventTemplates.EventFParamName + ");\n"
				+ "}\n//else unhandled event in this state\n" + "return handled;\n" + "}\n";
	}

	private static final String simpleProcessEventDefBody() {
		return "{\n" + "bool handled=false;\n" + "auto range = " + TransitionTableName + ".equal_range(EventState("
				+ EventTemplates.EventFParamName + GenerationNames.PointerAndMemoryNames.PointerAccess + "getType(),"
				+ CurrentStateName + "," + EventTemplates.EventFParamName
				+ GenerationNames.PointerAndMemoryNames.PointerAccess + "getPortType()));\n" + "if(range.first!="
				+ TransitionTableName + ".end())\n" + "{\n" + "for(auto it=range.first;it!=range.second;++it)\n" + "{\n"
				+ "if((it->second).first(*this," + EventTemplates.EventFParamName + "))//Guard call\n" + "{\n"
				+ EntryExitNames.ExitInvoke + "(it->second).second(*this," + EventTemplates.EventFParamName + ");//Action Call\n"
				+ EntryExitNames.EntryInvoke + "handled=true;\n" + "break;\n" + "}\n" + "}\n" + "}\n" + "return handled;\n" + "}\n";
	}

	private static final String setStateFunctionDefSharedHeaderPart(String className) {
		return ModifierNames.NoReturn + " " + className + "::" + SetStateFuncName + "(int "
				+ GenerationNames.StateParamName + ")";
	}

	private static final String setStateFunctionDefSharedStatementPart() {
		return CurrentStateName + "=" + GenerationNames.StateParamName + ";";
	}

	public static String simpleSetStateDef(String className) {
		return setStateFunctionDefSharedHeaderPart(className) + "{" + setStateFunctionDefSharedStatementPart() + "}\n";
	}

	public static String hierachicalSetStateDef(String className) {

		return setStateFunctionDefSharedHeaderPart(className) + "\n" + "{\n" + "auto it=" + HierarchicalStateMachineNames.CompositeStateMapName
				+ ".find(" + GenerationNames.StateParamName + ");\n" + "if(it!=" + HierarchicalStateMachineNames.CompositeStateMapName + ".end())\n"
				+ "{\n" + HierarchicalStateMachineNames.CurrentMachineName + "=(it->second).get();\n" + HierarchicalStateMachineNames.CurrentMachineName + "->"
				+ SetInitialStateName + "();//restarting from initial state\n" + "}\n" + "else\n" + "{\n"
				+ HierarchicalStateMachineNames.CurrentMachineName + "=" + PointerAndMemoryNames.NullPtr + ";\n" + "}\n" + CurrentStateName + "="
				+ GenerationNames.StateParamName + ";\n" + "}\n";
	}

	public static String eventClassName(String eventName) {
		return eventName + EventClassTypeId;
	}

	public static String eventEnumName(String eventName) {
		return eventName + EventEnumTypeId;
	}

	public static String stateEnumName(String stateName) {
		return stateName + StateEnumTypeId;
	}

	public static String derefenrencePointer(String pointer) {
		return "(*" + pointer + ")";
	}

	public static String pointerType(String typeName) {
		return typeName + "*";
	}

	public static String signalPointerType(String signalClassName) {
		return sharedPtrType(PrivateFunctionalTemplates.signalType(signalClassName));
	}

	public static String formatIncomingParamName(String paramName) {
		if (paramName.isEmpty())
			return "";

		return paramName + IncomingParamTypeId;
	}

	public static String sharedPtrType(String typeName) {

		return PointerAndMemoryNames.SmartPtr + "<" + typeName + ">";
	}
}

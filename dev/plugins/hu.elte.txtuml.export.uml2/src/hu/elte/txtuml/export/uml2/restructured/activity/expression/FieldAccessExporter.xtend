package hu.elte.txtuml.export.uml2.restructured.activity.expression

import hu.elte.txtuml.export.uml2.restructured.BaseExporter
import hu.elte.txtuml.export.uml2.restructured.activity.ActionExporter
import org.eclipse.jdt.core.dom.Expression
import org.eclipse.jdt.core.dom.FieldAccess
import org.eclipse.jdt.core.dom.IVariableBinding
import org.eclipse.jdt.core.dom.Name
import org.eclipse.jdt.core.dom.QualifiedName
import org.eclipse.uml2.uml.ReadStructuralFeatureAction
import org.eclipse.uml2.uml.StructuralFeature
import org.eclipse.jdt.core.dom.Modifier
import org.eclipse.jdt.core.dom.SuperFieldAccess
import org.eclipse.uml2.uml.Action
import hu.elte.txtuml.utils.jdt.ElementTypeTeller

abstract class FieldAccessExporter<T extends Expression> extends ActionExporter<T, ReadStructuralFeatureAction> {

	new(BaseExporter<?, ?, ?> parent) {
		super(parent)
	}

	def IVariableBinding resolveBinding(T source)

	def Action getExpression(T source)

	override create(T access) {
		if(ElementTypeTeller.isFieldAccess(access)) factory.createReadStructuralFeatureAction
	}

	override exportContents(T source) {
		result.name = source.resolveBinding.name
		result.createResult(result.name, fetchType(source.resolveBinding.type))
		if (!Modifier.isStatic(source.resolveBinding.modifiers)) {
			val base = source.expression
			base.result.objectFlow(result.createObject("object", base.result.type))
		}
		result.structuralFeature = fetchElement(source.resolveBinding) as StructuralFeature
	}
}

class NameFieldAccessExporter extends FieldAccessExporter<Name> {

	new(BaseExporter<?, ?, ?> parent) {
		super(parent)
	}

	override resolveBinding(Name source) { source.resolveBinding as IVariableBinding }

	override getExpression(Name source) {
		if (source instanceof QualifiedName) {
			exportExpression((source as QualifiedName).qualifier)
		} else {
			new ThisExporter(this).createThis((source.resolveBinding as IVariableBinding).declaringClass)
		}
	}

}

class SimpleFieldAccessExporter extends FieldAccessExporter<FieldAccess> {

	new(BaseExporter<?, ?, ?> parent) {
		super(parent)
	}

	override resolveBinding(FieldAccess source) { source.resolveFieldBinding }

	override getExpression(FieldAccess source) { exportExpression(source.expression) }
}

class SuperFieldAccessExporter extends FieldAccessExporter<SuperFieldAccess> {

	new(BaseExporter<?, ?, ?> parent) {
		super(parent)
	}

	override resolveBinding(SuperFieldAccess source) { source.resolveFieldBinding }

	override getExpression(SuperFieldAccess source) {
		new ThisExporter(this).createThis(source.resolveFieldBinding.declaringClass)
	}
}


package hu.elte.txtuml.api.model;

import java.util.function.Consumer;

import com.google.common.collect.ImmutableSet;

import hu.elte.txtuml.api.model.GeneralCollection.Unique;
import hu.elte.txtuml.api.model.GeneralCollection.Unordered;

// TODO document
public abstract class UniqueCollection<E, C extends UniqueCollection<E, C>>
		extends AbstractGeneralCollection<E, C> implements @External Unordered<E>, @External Unique<E> {

	@ExternalBody
	protected UniqueCollection() {
	}

	@ExternalBody
	@Override
	@SuppressWarnings("unchecked")
	public final <C2 extends GeneralCollection<? super E>, C3 extends GeneralCollection<?>> C2 as(
			Class<C3> collectionType) {
		if (Unordered.class.isAssignableFrom(collectionType)) {
			return (C2) asUnsafe(collectionType);
		} else {
			// TODO exception handling
			throw new Error();
		}
	}

	@ExternalBody
	@Override
	public final UniqueAny<E> unbound() {
		return asUniqueAnyUnsafe();
	}

	@Override
	java.util.Set<E> createBackend(Consumer<Builder<E>> backendBuilder) {
		ImmutableSet.Builder<E> builder = ImmutableSet.builder();
		backendBuilder.accept(builder::add);
		return builder.build();
	}

	@ExternalBody
	@Override
	public final String toString() {
		return "{" + super.toString() + "}";
	}

}
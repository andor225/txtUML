package hu.elte.txtuml.api.model;

import java.util.function.Consumer;

import com.google.common.collect.ImmutableSet;

import hu.elte.txtuml.api.model.GeneralCollection.Unique;
import hu.elte.txtuml.api.model.GeneralCollection.Unordered;

// TODO document
public abstract class UniqueCollection<E, C extends UniqueCollection<E, C>>
		extends AbstractGeneralCollection<E, java.util.Collection<E>, C> implements Unordered<E>, Unique<E> {

	protected UniqueCollection() {
	}

	@Override
	public <C2 extends GeneralCollection<E>> C2 as(Class<C2> collectionType) {
		if (Unordered.class.isAssignableFrom(collectionType)) {
			return asUnsafe(collectionType);
		} else {
			// TODO exception handling
			throw new Error();
		}
	}

	@Override
	public final GeneralCollection<E> unbound() {
		return asUniqueAnyUnsafe();
	}

	@Override
	final java.util.Collection<E> getUninitializedBackend() {
		return null; // TODO uninitialized collection
	}

	@Override
	java.util.Set<E> createBackend(Consumer<Builder<E>> backendBuilder) {
		ImmutableSet.Builder<E> builder = ImmutableSet.builder();
		backendBuilder.accept(builder::add);
		return builder.build();
	}

}
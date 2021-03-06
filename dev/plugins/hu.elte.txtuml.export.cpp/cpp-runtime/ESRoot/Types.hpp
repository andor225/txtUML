#ifndef TYPES_HPP
#define TYPES_HPP

#include <string>
#include <memory>
#include <queue>
#include "Containers/PriorityQueue.hpp"

namespace Model
{
class StateMachineOwner;

}

namespace Model
{
template<typename BaseDerived>
class IEvent;
class EventBase;
template<typename BaseDerived>
class SpecialEventChecker;
}


namespace Execution 
{
template<typename RuntimeType>
class IRuntime;
}

namespace ES
{
class Timer;

template<typename T>
class ThreadSafeQueue;

template<typename T, typename Compare>
class SpecialPriorityQueue;

}


namespace ES
{
	//basic types
	using String = std::string;

	//ref types
	template<typename T>
	using SharedPtr = std::shared_ptr<T>;

	using EventRef = SharedPtr<Model::IEvent<Model::EventBase>>;
	using EventConstRef = SharedPtr<const Model::IEvent<Model::EventBase>>;

	using StateMachineRef = Model::StateMachineOwner*;
	using StateMachineConstRef = Model::StateMachineOwner const *;

	template<typename RuntimeType>
	using RuntimePtr = SharedPtr<Execution::IRuntime<RuntimeType>>;

	//ThreadSafeQueue types
	using MessageQueueType = ThreadSafeQueue<SpecialPriorityQueue<EventRef, Model::SpecialEventChecker<Model::EventBase>>>;
	using PoolQueueType = ThreadSafeQueue<Queue<StateMachineRef>>;

	using TimerPtr = SharedPtr<Timer>;


}

#endif

CXX ?= g++
CXX_FLAGS ?= --std=c++0x -Wall -Wextra
INCLUDE_FLAGS = -I .
PROGRAMS = cut total
ALL = $(PROGRAMS)
HEADERS = $(shell find -name "*.hpp")

define BUILD_TEMPLATE
  $(1): $(1).cpp $(HEADERS)
	$(CXX) $(1).cpp $(CXX_FLAGS) $(INCLUDE_FLAGS) -o $(1)
endef

all: $(ALL)

$(foreach target,$(PROGRAMS),$(eval $(call BUILD_TEMPLATE,$(target))))

legacy-kata
===========

A Legacy Code kata that focuses on refactoring an ugly piece of legacy code.

This kata contains a lot of common flaws for pedagogical purposes:
- Cyclomatic complexity
- Code duplication
- Lack of dependency injection
- Dependency cycle
- Bad Entity/Value-object choice
- Non-deterministic processing
- Static service

Context & Instructions
----------------------

This is an application to search facts ("birth of Elvis Presley"...) by keywords, and to find related facts as well.

You're given this code base with the following instructions:
- BUG: when the user enters a too long sentence in the input, then the application closes
- ENHANCEMENT: we need to evolve the dates comparison: facts with the same days (and month) on different years must be considered equals




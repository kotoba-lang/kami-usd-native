# ADR 0001: Kotoba source authority

## Status

Accepted.

## Decision

`src/usd_native.kotoba` is the sole production source for this contingent USD
fallback reservation. Production `.clj`, `.cljc`, and `.cljs` are forbidden.

The contract contains metadata only. USD parsing/composition, native code,
WebGPU, rendering, and device capabilities remain inactive Kami providers
until the external viability and Council gates are satisfied.

Closed typed string getters preserve every scalar and each member of the two
former string vectors. Tests execute them through the reference evaluator,
restricted JavaScript, and instantiated typed Wasm. Compatibility is semantic
and ABI-based, not Wasm byte identity.

The JVM is permitted only as compiler/test infrastructure.

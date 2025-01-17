package dev.drewhamilton.poko.sample.jvm.arrays

/**
 * Reproduces the byte code generated by an equivalent data or Poko class.
 */
@Suppress("unused")
class HandwrittenArrayHolder(
    val id: String,
    val array: Array<String>,
    val maybe: Any?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true

        if (other !is HandwrittenArrayHolder)
            return false

        if (this.id != other.id)
            return false

        @Suppress("ReplaceArrayEqualityOpWithArraysEquals")
        if (this.array != other.array)
            return false

        if (this.maybe != other.maybe)
            return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()

        result = result * 31 + array.contentHashCode()

        result = result * 31 + maybe.hashCode()

        return result
    }

    override fun toString(): String {
        return StringBuilder()
            .append("HandwrittenArrayHolder(")
            .append("id=")
            .append(id)
            .append(", ")
            .append("array=")
            .append(array.contentToString())
            .append(", ")
            .append("maybe=")
            .append(maybe)
            .append(")")
            .toString()
    }
}

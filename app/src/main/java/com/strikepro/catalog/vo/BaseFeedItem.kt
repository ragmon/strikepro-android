package com.strikepro.catalog.vo

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Feed item base class.
 */
abstract class BaseFeedItem (
        @JsonProperty("resource_type")
        var resource_type: ResourceType = ResourceType.UNKNOWN
)
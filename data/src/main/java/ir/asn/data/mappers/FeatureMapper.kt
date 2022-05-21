package ir.asn.data.mappers

import ir.asn.data.models.FeatureEntity
import ir.asn.domain.models.Feature
import javax.inject.Inject

class FeatureMapper @Inject constructor() : Mapper<FeatureEntity, Feature> {
    override fun mapFromEntity(type: FeatureEntity): Feature {
        return Feature(
            description = type.description,
            icon = type.icon,
            title = type.title
        )
    }

    override fun mapToEntity(type: Feature): FeatureEntity {
        return FeatureEntity(
            description = type.description,
            icon = type.icon,
            title = type.title
        )
    }
}
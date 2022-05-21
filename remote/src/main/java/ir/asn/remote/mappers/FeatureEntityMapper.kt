package ir.asn.remote.mappers

import ir.asn.data.models.FeatureEntity
import ir.asn.remote.models.FeatureModel
import javax.inject.Inject

class FeatureEntityMapper @Inject constructor() : EntityMapper<FeatureModel, FeatureEntity> {
    override fun mapFromModel(model: FeatureModel): FeatureEntity {
        return FeatureEntity(
            description = model.description,
            icon = model.icon,
            title = model.title
        )
    }
}
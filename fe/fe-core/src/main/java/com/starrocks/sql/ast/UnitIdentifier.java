// This file is licensed under the Elastic License 2.0. Copyright 2021-present, StarRocks Limited.

package com.starrocks.sql.ast;

import com.google.gson.annotations.SerializedName;
import com.starrocks.analysis.ParseNode;
import com.starrocks.common.io.Text;
import com.starrocks.common.io.Writable;
import com.starrocks.persist.gson.GsonUtils;

import java.io.DataOutput;
import java.io.IOException;

public class UnitIdentifier implements ParseNode, Writable {

    @SerializedName(value = "description")
    private final String description;

    public UnitIdentifier(String description) {
        this.description = description.toUpperCase();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        Text.writeString(out, GsonUtils.GSON.toJson(this));
    }
}

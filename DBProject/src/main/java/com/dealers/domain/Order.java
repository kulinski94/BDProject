package com.dealers.domain;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.dealers.validation.FormValidationGroup;

public class Order {

	@NotNull(message="You must pick at least one photo",groups={FormValidationGroup.class})
	private List<Integer> selectedIds;

	public List<Integer> getSelectedIds() {
		return selectedIds;
	}

	public void setSelectedIds(List<Integer> selectedIds) {
		this.selectedIds = selectedIds;
	}

	@Override
	public String toString() {
		return "Order [selectedIds=" + (selectedIds.toString()) + "]";
	}

}

package com.ahirajustice.drones.modules.file.viewmodels;

import com.ahirajustice.drones.common.viewmodels.BaseViewModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileViewModel extends BaseViewModel {

    private String reference;
    private int url;

}

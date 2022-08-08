//
//  SearchViewModel.swift
//  radioJavanIOS
//
//  Created by Mehrpooya Alinezhad on 5/1/1401 AP.
//  Copyright © 1401 AP orgName. All rights reserved.
//

import Foundation
import KMPNativeCoroutinesAsync
import Combine
import radioJavanShared

class SearchViewModel : ObservableObject {
    let repository = RadioJavanRepository.init()
    @Published
    var results : SearchResults? = nil
    
    @Published
    var error : String? = nil
    
    private var getSearchResults : Task<(),Never>? = nil
    
    @Published
    var isLoading : Bool = false
    
    func onTriggerEvent(query : String) {
        getSearchResults = Task {
            do {
                let stream = asyncStream(for: repository.searchNative(query: query))
                for try await data in stream {
                    self.isLoading = data.loading
                    if (data.data != nil){
                        self.results = data.data
                    }
                    if (data.error != nil){
                        self.error = data.error?.description
                    }
                }
            }catch{
                
                
            }
        }
    }
    
}

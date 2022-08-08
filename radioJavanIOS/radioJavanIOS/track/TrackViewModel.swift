//
//  TrackViewModel.swift
//  radioJavanIOS
//
//  Created by Mehrpooya Alinezhad on 4/30/1401 AP.
//  Copyright © 1401 AP orgName. All rights reserved.
//

import Foundation
import AVKit
import radioJavanShared
import KMPNativeCoroutinesAsync
import Combine

class TrackViewModel : ObservableObject {
    
  
    private let repository = RadioJavanRepository.init()
    
    @Published
    var track : Track? = nil
    
    @Published
    var error : String? = nil
    
    @Published
    var isLoading : Bool = false
    
    @Published
    var player : AVPlayer? = nil
    
    @Published
    var relateds : [Related]? = nil
    
    private var getTrack : Task<(),Never>? = nil
    
    @Published
    var backgroundColor : String? = nil
    @Published
    var trackPhoto : String? = nil
    @Published
    var title : String? = nil
    
    func onTriggerEvent(id : Int){
        resetParameters()
        getTrack = Task {
            do {
                let stream = asyncStream(for: repository.getTrackFromNetworkNative(id: Int32(id)))
                for try await dataState in stream {
                    isLoading = dataState.loading
                    error = dataState.error
                    track = dataState.data
                    if (track != nil){
                        player = AVPlayer(url: URL(string: track?.link ?? "")!)
                        relateds = (track?.related as! [Related])
                        backgroundColor = track?.bgColors?.first as? String
                        trackPhoto = track?.photo
                    
                        title = track?.title
                    }
                }
            }catch{}
                
            }
        }
    
    func resetParameters(){
        player = nil
        
    }
}
